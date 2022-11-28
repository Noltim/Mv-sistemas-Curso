const { response } = require('express');
const express = require('express');
const router = express.Router();
const validationMiddleware = require("../middlewares/validationMiddlewares")
const userController = require("../controllers/userController")

/* GET users listing. */
router.get('/', userController.getUser);

router.get('/:id', userController.getUserId );


router.post('/', validationMiddleware, userController.postUser)

router.put('/:id', validationMiddleware, userController.putUser)

router.patch('/:id',validationMiddleware, userController.patchUser )

router.delete('/:id', userController.deleteUser)

module.exports = router;
