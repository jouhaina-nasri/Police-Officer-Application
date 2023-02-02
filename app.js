const express = require('express');
const mongoose = require('mongoose');
const Person = require('./models/person');
const app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

mongoose.promise = global.Promise;
const  DB = 'mongodb://mongo:27017/policeDB' ;
mongoose.connect(DB, { useNewUrlParser: true }).then(
  () => {console.log('Database is connected') },
  err => { console.log('Can not connectttt to the database '+ err)}
);
mongoose.set('debug', true);

app.use(express.json());

app.use((req, res, next) => {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content, Accept, Content-Type, Authorization');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
    next();
  });

app.post('/', function (req, res) {
    Person.create({
        cin: req.body.cin,
        recherche: req.body.recherche,
        infractions: req.body.infractions,
    },  
        function (err, person) {
            console.log(req.body);
            if (err) return res.status(500).send(err);
            res.status(200).send(person);
        });
});

app.get('/', (req, res, next) => {
    Person.find()
      .then(persons => res.status(200).json(persons))
      .catch(error => res.status(400).json({ error }));
  }); 

app.get('/:cin', (req, res, next) => {
    Person.findOne({ cin: req.params.cin })
      .then(person => res.status(200).json(person))
      .catch(error => res.status(404).json({ error }));
  });

app.delete('/:id', function (req, res) {
    Person.findByIdAndDelete(req.params.id, function (err, user) {
        if (err) return res.status(500).send("There was a problem deleting the user.");
        res.status(200).send(user);
    });
});
module.exports = app;