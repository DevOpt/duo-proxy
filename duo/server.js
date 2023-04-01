const http = require('http');

const server = http.createServer((req, res) => {
  console.log(`Request headers: ${JSON.stringify(req.headers)}`);

  const data = {
    message: 'Hello, World!'
  };

  res.writeHead(200, {
    'Content-Type': 'application/json'
  });

  res.end(JSON.stringify(data));
});

const PORT = 3000;

server.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}/`);
});
