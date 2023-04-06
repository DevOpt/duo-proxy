const express = require('express')
const app = express()

app.get("/", (req, res) => {
    console.log(`Request headers: ${JSON.stringify(req.headers)}`);
    res.send({
      message: 'Hello world!'
    });
});

app.get("/ping", (req, res) => {
    console.log(`Request headers: ${JSON.stringify(req.headers)}`);
    res.send({
      message: 'Pinging Duo server!'
    });
});

app.get("/messages/latest", (req, res) => {
    console.log(`Request headers: ${JSON.stringify(req.headers)}`);
    res.send({
      message: 'Message received with 0 errors!'
    });
});

app.listen(3000, () => {
    console.log("listening on http://localhost:3000");
})
