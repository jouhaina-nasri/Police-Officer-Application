const mongoose = require('mongoose');

const personSchema = mongoose.Schema({
  cin: { type: String, required: true },
  recherche: { type: String, required: true },
  infractions: { type: String },

});

module.exports = mongoose.model('Person', personSchema);