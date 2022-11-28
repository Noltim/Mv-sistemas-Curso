//db.js
const ObjectId = require('mongodb').ObjectId;
const mongoClient = require("mongodb").MongoClient;

function connectDataBase(){
    if(!global.connection)
mongoClient.connect(process.env.MONGODB_CONNECTION,
    { useUnifiedTopology: true })
    .then(connection => {
        global.connection = connection.db("aula02");
        console.log("Connected!");
    })
    .catch(error => {
        console.log(error)
        global.connectDataBase = null;
    });
};

function findCustomers() {
    connectDataBase()
    return global.connection
        .collection("clientes")
        .find({})
        .toArray();
}

function findCustomer(id){
    connectDataBase()
    const objectId = new ObjectId(id);
    return global.connection
    .collection('clientes')
    .findOne({_id: objectId})
}


function insertCustomer(customer) {
    connectDataBase()
    return global.connection
        .collection('clientes')
        .insertOne(customer);
}

function updateCustomer(id, customer) {
    connectDataBase()
    const objectId = new ObjectId(id);
    return global.connection
        .collection('clientes')
        .updateOne({ _id: objectId }, { $set: customer });
}

function deleteCustomer(id) {
    connectDataBase()
    const objectId = new ObjectId(id);
    return global.connection
        .collection('clientes')
        .deleteOne({ _id: objectId })
}


module.exports = {
    findCustomers,
    findCustomer,
    insertCustomer,
    updateCustomer,
    deleteCustomer
};