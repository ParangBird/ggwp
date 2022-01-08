import React, { useEffect, useState } from "react";
import RankTable from "../components/ranking/RankTable";
import RankSearch from "../components/ranking/RankSearch";
import {Button} from "react-bootstrap";

export default function(){

    const [name, setName] = useState('d')

    return(
        <>
            <h1>ranking page</h1>
            <h2>{name}</h2>
            <RankSearch changeName = {setName}/>
            <RankTable name = {name} changeName = {setName}/>
        </>
    )
}