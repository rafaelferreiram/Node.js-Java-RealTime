const net = require('net');

const host = "localhost";
const door = 3001;

net.createServer(function(sock){
	console.log('Conectando: '+sock.remoteAddress+':'+sock.remotePort);

	sock.on('data',function(data){
		console.log(data.toString());
		sock.write(data);
	});

	sock.on('close',function(data){
		console.log('Fechando: '+sock.remoteAddress+':'+sock.remotePort);
	});
}).listen(door,host);

console.log('Server escutando na ' + host +':'+ door);