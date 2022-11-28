import { Router } from "express";
import linksController from '../controllers/links'

const router = Router();


router.post('/links', linksController.postLink );

router.get('/links/:code/stats',  linksController.getLink);

router.get('/links/:code',  linksController.hitLink);

export default router;