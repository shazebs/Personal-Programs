const { send } = require('./request'); 
const { read } = require('./response'); 

function makeRequest(url, data){
    send(url, data); 
    return read(); 
}

const responseData = makeRequest('https://www.shazebs.com', 'Hello WRLD'); 
console.log(responseData); 
