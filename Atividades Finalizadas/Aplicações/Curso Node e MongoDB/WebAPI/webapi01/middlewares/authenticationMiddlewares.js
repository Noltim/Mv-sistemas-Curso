const keyModel = require("../models/keyModel")

module.exports = (req, res, next) => {
    const key = req.headers['authorization']
    const apiKey = keyModel.findKey(key.replace("ApiKey ", ""))

    if (apiKey && apiKey.enabled)
        return next();
    else
        res.sendStatus(401);
}