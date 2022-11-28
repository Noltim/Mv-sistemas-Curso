//index.js
const movies = require('./api/movies')
const repository = require('./repository/repository')
const server = require('./server/server')

async function serveStart() {

    try{
        await server.start(movies, repository);
    }
    catch(error){
        console.error(error)
    }
    };
    
    serveStart();
