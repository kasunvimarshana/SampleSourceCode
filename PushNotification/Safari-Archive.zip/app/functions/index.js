const functions = require('firebase-functions');
const express = require('express');

const app = express();

app.post('/v1/pushPackages/web.com.firebaseapp.pushtestapp-cfc3b',(req, res) => {
    res.sendFile('pushPackage.zip',{root:__dirname});
})

exports.app = functions.https.onRequest(app);
