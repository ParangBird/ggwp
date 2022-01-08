import React, { useState } from "react";
import RankTable from "../components/ranking/RankTable";
import RankSearch from "../components/ranking/RankSearch";

export default function(){

    const [name, setName] = useState('d')

    return(
        <>
            <h1>ranking page</h1>
            <RankSearch changeName = {setName}/>
            <RankTable name = {name} changeName = {setName}/>
        </>
    )
}