const { v4 } = require('uuid');
const fs = require('fs');
const FILE_PATH = require("path").join(__dirname, "..", "data", "users.json");

function findUsers() {

    if (!fs.existsSync(FILE_PATH)) return [];

    const rawData = fs.readFileSync(FILE_PATH)
    return JSON.parse(rawData);
};

function findUser(id) {
    return findUsers().find(item => item.id === id);
};

function insertUsers(user) {
    const users = findUsers();
    user.id = v4();
    users.push(user);
    fs.writeFileSync(FILE_PATH, JSON.stringify(users))
    return user;
};

function updateUser(id, user, ovewrite) {
    const users = findUsers();
    const index = users.findIndex(item => item.id === id)

    if (index === -1) return {};

    if (ovewrite)
        users[index] = user;
    else {
        for (let key in user) {
            users[index][key] = user[key];
        }
    }
    fs.writeFileSync(FILE_PATH, JSON.stringify(users))
    return users[index];
};

function deleteUser(id) {
    const users = findUsers();
    users.forEach((item, index, array) => {
        if (item.id === id)
            array.splice(index, 1)
    })
    return id
};

module.exports = {
    findUsers,
    findUser,
    insertUsers,
    updateUser,
    deleteUser
}