import React from "react";
import { Route, Routes } from 'react-router-dom'


import HomePage from '../pages/HomePage';
import RedirectPage from '../pages/RedirectPage';
import StatsPage from '../pages/StatsPage';



export default function MainRoutes() {
    <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/:code' element={<RedirectPage />} />
        <Route path='/:code/stats' element={<StatsPage />} />
    </Routes>

}