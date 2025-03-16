import http from 'http';
http.createServer((request, response) => {
  request.on('error', err => {
    // Обрабатываем ошибки
    console.error(err);
  }).on('end', () => {
    response.on('error', err => {
      // Обрабатываем ошибки
      console.error(err);
    });

    // Устанавливаем код ответа
    response.statusCode = 200;
    // Устанавливаем заголовки
    response.setHeader('Content-Type', 'application/json');

    const message = 'Welcome to The Phonebook';
    // Устанавливаем данные в ответе
    response.write(message);
    // Завершаем соединение
    response.end();
  });
  request.resume(); // !!!
}).listen(8080);