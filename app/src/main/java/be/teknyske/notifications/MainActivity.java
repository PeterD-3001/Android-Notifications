package be.teknyske.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    // Buttons for notifications
    private Button btnHighPriorityNotification;

    private NotificationManager manager;
    private int count = 1;
    private int NOTIF_REF = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Butonnekes hier
        btnHighPriorityNotification = (Button) findViewById(R.id.btnHighPriorityNotification);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        btnHighPriorityNotification.setOnClickListener(this);
        }

    @Override
    public void onClick(View v)
        {
        Notification notif = null;
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentText("Android Notifications");

        // Depending on what button is clicked....
        switch (v.getId())
            {
            case R.id.btnHighPriorityNotification:
                builder.setContentTitle("Peter's First High Priority Notification");
                builder.setPriority(Notification.PRIORITY_HIGH);
                sendNotification(builder.build());
                break;

            default:
                break;

            }

        }

    public void sendNotification(Notification notif)
        {
        manager.notify(NOTIF_REF++, notif);
        }
}
