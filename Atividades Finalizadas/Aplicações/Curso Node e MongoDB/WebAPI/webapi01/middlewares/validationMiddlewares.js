const userSchema = require('../models/userSchema')

module.exports =  (request, response, next) => {
    if (["POST", "PUT"].indexOf(request.method) !== -1) {
      if (!request.body.nome || !request.body.idade)
        return response.status(422).json({ error: "nome and idade are required." })
    }
  
    const { error } = userSchema.validate(request.body);
    if (error)
      return response.status(422).json({ error: error.details });
    else
      next();
  }