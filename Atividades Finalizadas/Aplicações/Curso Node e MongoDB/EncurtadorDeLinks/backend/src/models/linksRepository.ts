import linkModel, {IlinkModel} from "./linkModel";
import { Link } from "./link";

function findByCode(code: string){
    return linkModel.findOne<IlinkModel>({ where: {code}});
}

function add(link: Link){
    return linkModel.create<IlinkModel>(link);
}

async function hit(code: string){
    const link = await findByCode(code);
    if(!link) return null;

    link.hits!++;
    await link.save();
    
    return link;
}

export default {
    findByCode,
    add,
    hit
}