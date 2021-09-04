const functions = require('firebase-functions');
const express = require('express');

const app = express();

app.get('/getTime', (requestAnimationFrame,res) => {

    res.send(`${Date.now()}`);

});

exports.app = functions.https.onRequest(app);
