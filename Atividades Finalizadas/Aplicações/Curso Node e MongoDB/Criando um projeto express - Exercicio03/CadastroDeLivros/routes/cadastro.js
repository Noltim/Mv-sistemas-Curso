var express = require('express');
var router = express.Router();

/* GET cadastro. */
router.get('/', function(req, res, next) {
  res.render('cadastro', {});
});

/* POST cadastro. */
router.post('/', function(req, res, next) {
    global.livros.push({nome: req.body.nome, tipo: req.body.tipo})
    res.redirect('/');
  });

module.exports = router;
