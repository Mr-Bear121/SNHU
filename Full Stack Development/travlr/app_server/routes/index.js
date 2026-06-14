var express = require('express');
const cors = require('cors');
var router = express.Router();
const ctrlMain = require("../controllers/main");

/* GET home page */
router.get('/',ctrlMain.index);

module.exports = router;