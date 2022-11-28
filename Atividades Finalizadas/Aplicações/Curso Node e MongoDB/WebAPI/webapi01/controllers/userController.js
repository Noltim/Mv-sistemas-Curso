const db = require('../models/userModel');

function getUser (req, res, next) {
    res.json(db.findUsers());
  }

  function getUserId(request, response) {
    const id = request.params.id;
    response.json(db.findUser(id));
  }

  function postUser(request, response) {
    const user = db.insertUsers(request.body);
    response.status(201).json(user);
  }

  function putUser (request, response) {
    const id = request.params.id;
    const user = db.updateUser(id, request.body, true)
    response.status(200).json(user);
  }

  function patchUser (request, response) {
    const id = request.params.id;
    const user = db.updateUser(id, request.body, false)
    response.status(200).json(user);
  }

  function deleteUser (request, response) {
    const id = request.params.id;
    db.deleteUser(id)
    response.status(200).json({})
  }

  module.exports = {
    getUser,
    getUserId,
    postUser,
    putUser,
    patchUser,
    deleteUser

  }