const path = require('path');

module.exports = {
  entry: './app/assets/javascripts/main.js',
  output: {
    path: path.resolve(__dirname, 'public/javascripts'),
    filename: 'lmp-bundle.js'
  }
};