const mongoose = require('mongoose');
const Trip = require('../models/travlr'); // register model
const Model = mongoose.model('trips');

// GET /trips - lists all of the trips
// regardless of outcome, response must include a HTML status code
// and JSON message to the requesting client

const tripsList = async(req, res) => {
    const q = await Model
    .find({}) // return all records
    .exec();

    // uncomment the following line to show results of querey
    // on the console
    // console.log(q);

    if(!q){// database returned no data

        return res
                .status(404)
                .json(err);
    } else { // Return resulting trip list
        return res
                .status(200)
                .json(q);

    };
    
}

const tripsFindByCode = async(req, res) => {
    const q = await Model
    .find({'code':req.params.tripCode}) // return a single record
    .exec();

    // uncomment the following line to show results of querey
    // on the console
    // console.log(q);

    if(!q){// database returned no data

        return res
                .status(404)
                .json(err);
    } else { // Return resulting trip list
        return res
                .status(200)
                .json(q);

    };
    
}
module.exports = {
    tripsList,
    tripsFindByCode
};