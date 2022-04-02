const { get } = require('https'); 

/* http request example */
const req = get('https://www.shazebs.com', (res) => {

    // data call  
    res.on('data', (chunk) => {
        console.log(`Data chunk ${chunk}`); 
    }); 

    // end call  
    res.on('end', () => {
        console.log('No more data'); 
    }); 

});
