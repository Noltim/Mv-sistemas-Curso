var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  if(!global.livros) global.livros=[];
  res.render('index', { title: 'Express', livros: global.livros });
});

module.exports = router;
