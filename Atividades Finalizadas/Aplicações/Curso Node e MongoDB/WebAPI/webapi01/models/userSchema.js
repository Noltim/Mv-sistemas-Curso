const Joi = require('joi');

module.exports = Joi.object({
    nome: Joi.string()
             .min(5)
             .max(150),

    idade: Joi.number()
              .integer()
              .min(18),

    uf: Joi.string()
           .length(2),

    senha: Joi.string()
              .min(6)
              .pattern(/^(?=.*[0-9]+.*)\w+$/i),

    email: Joi.string()
              .email({minDomainSegments: 2, tlds:{
                allow: ['com', 'net', 'br']
              }})     

});