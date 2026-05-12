// Bring in the DB connection and the Trip Schema
const Mongoose = require('./db');
const trip = require('./travlr');

// Read seed data from json file
var fs = require('fs');
//const path = require('path');
//const filePath = path.join(__dirname, './data/trips.json');
//var trips = JSON.parse(fs.readFileSync(filePath, 'utf8'));      
var trips = JSON.parse(fs.readFileSync("./app_server/data/trips.json",'utf8'));

// Delete any existing records, then insert seed data
const seedDB = async () => {
await trip.deleteMany({});
await trip.insertMany(trips);

}

// Close the MongoDB connection and exit
seedDB().then(async () => {
    await Mongoose.connection.close();
    process.exit(0);
});