const passport = require("passport");
const LocalStrategy = require('passport-local').Strategy;
const mongoose = require("mongoose");
const Users = require('../models/user');
const User = mongoose.model('users');



passport.use(

    {
        usernameField: "email",
    },
    async(username,password,done) => {
        const q = await User.findOne({ email: udrename}).exec();
        if(!q){
            return done(null,false, {
                message: "incorrect udername.",

            });

        }
        if(!q.validPassword(password)){
            return done(null, false, {
                message: "Incorrect password.",
            });
        }
        return done(null,q);
    }

)