var fs = require("fs");
// wasnt working correctly so I used an absolute path instead.
//var trips = JSON.parse(fs.readFileSync('./data/trips.json','utf8'));
var trips = JSON.parse(fs.readFileSync('/home/mrbear/Desktop/GitHub Repository/SNHU/Full Stack Development/travlr/app_server/data/trips.json','utf8'));

/* GET travel view*/
const travel = (req,res) => {
    res.render('travel',{ title: 'travlr getaways',trips})
}

module.exports = {
    travel
};
