package com.company.fsmapp.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.lang.Exception

class MyFCM : FirebaseMessagingService() {
    private val TAG = "MyFCM"

    override fun onMessageSent(message: String) {
        Log.e("message",message)
        super.onMessageSent(message)
    }

    override fun onSendError(message: String, err: Exception) {
        Log.e("message",message)
        Log.e("err",err.message.toString())
        super.onSendError(message,err)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...

        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: ${remoteMessage.from}")

        // Check if message contains a data payload.
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    override fun onNewToken(token: String) {

        sendRegistrationToServer(token)
    }


    private fun sendRegistrationToServer(token: String) {
        // Implement this method to send token to your app server.
        Log.e("send",token)
    }
}