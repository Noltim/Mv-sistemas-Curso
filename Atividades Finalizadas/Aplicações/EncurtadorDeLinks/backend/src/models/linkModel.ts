import Sequelize, {Optional, Model } from "sequelize";
import {Link} from "./link";
import database from "../database";

interface IlinkCreationAttributes extends Optional<Link, "id">{}

export interface IlinkModel extends Model<Link, IlinkCreationAttributes>, Link{}

const linkModel = database.define<IlinkModel>('link', {
    id: {
        type: Sequelize.INTEGER.UNSIGNED,
        primaryKey: true,
        autoIncrement: true,
        allowNull: false
    },
    url: {
        type: Sequelize.STRING(255),
        allowNull: false
    },
    code: {
        type: Sequelize.STRING(20),
        unique: true,
        allowNull: false
    },
    hits: {
        type: Sequelize.INTEGER.UNSIGNED,
        allowNull: false,
        defaultValue: 0
    }
})

export default linkModel;