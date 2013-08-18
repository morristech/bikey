package org.jraf.android.bikey.backend;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import org.jraf.android.bikey.R;
import org.jraf.android.bikey.app.hud.HudActivity;
import org.jraf.android.bikey.backend.location.LocationManager;
import org.jraf.android.bikey.backend.log.LogManager;
import org.jraf.android.bikey.backend.ride.RideManager;
import org.jraf.android.util.Log;
import org.jraf.android.util.string.StringUtil;

import com.google.android.gms.location.LocationListener;

public class LogCollectorService extends Service {
    private static final String PREFIX = LogCollectorService.class.getName() + ".";
    public static final String ACTION_START_COLLECTING = PREFIX + "ACTION_START_COLLECTING";
    public static final String ACTION_STOP_COLLECTING = PREFIX + "ACTION_STOP_COLLECTING";

    private static final int NOTIFICATION_ID = 1;
    private Uri mCollectingRideUri;
    protected Location mLastLocation;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("intent=" + StringUtil.toString(intent));
        String action = intent.getAction();
        if (ACTION_START_COLLECTING.equals(action)) {
            startCollecting(intent.getData());
        } else if (ACTION_STOP_COLLECTING.equals(action)) {
            stopCollecting(intent.getData());
        }
        return Service.START_STICKY;
    }

    private void startCollecting(Uri rideUri) {
        // First, pause current ride if any
        if (mCollectingRideUri != null) {
            RideManager.get().pause(mCollectingRideUri);
        }
        // Now collect for the new current ride
        mCollectingRideUri = rideUri;
        RideManager.get().activate(mCollectingRideUri);
        Notification notification = createNotification();
        startForeground(NOTIFICATION_ID, notification);
        LocationManager.get().addLocationListener(mLocationListener);
    }

    private void stopCollecting(Uri rideUri) {
        RideManager.get().pause(rideUri);
        dismissNotification();
        LocationManager.get().removeLocationListener(mLocationListener);
        mCollectingRideUri = null;
        stopSelf();
    }


    /*
     * Listener.
     */

    private LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            LogManager.get().add(mCollectingRideUri, location, mLastLocation);
            mLastLocation = location;
        }
    };


    /*
     * Notification.
     */

    private Notification createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setOngoing(true);
        builder.setSmallIcon(R.drawable.ic_stat_collecting);
        builder.setTicker(getString(R.string.service_notification_ticker));
        builder.setContentTitle(getString(R.string.app_name));
        builder.setContentText(getString(R.string.service_notification_text));
        builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, HudActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        //TODO
        //        builder.addAction(R.drawable.ic_action_stop, getString(R.string.service_notification_action_stop),
        //                PendingIntent.getBroadcast(this, 0, new Intent(ACTION_DISABLE), PendingIntent.FLAG_CANCEL_CURRENT));
        //        builder.addAction(R.drawable.ic_action_logs, getString(R.string.service_notification_action_logs),
        //                PendingIntent.getActivity(this, 0, new Intent(this, LogActivity.class), PendingIntent.FLAG_UPDATE_CURRENT));
        Notification notification = builder.build();
        return notification;
    }

    private void dismissNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(NOTIFICATION_ID);
    }
}