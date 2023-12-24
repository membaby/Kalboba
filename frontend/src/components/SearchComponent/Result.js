import React from "react";
import './styles.css';

export default function Result( { details } ) {

    return (<>
        <div className="result mt-2">
            <div className="row">
                <div className="col-auto">
                    <div className="avatar-container">
                        <img src={`/animals/`+details.image} alt="Pet" className="avatar" width="150px" />
                    </div>
                </div>
                <div className="col">
                    <a href={`/adopt/`+details.id}><button className="result-button result-button-primary w-100 mt-3 mb-3">Adopt Now</button></a>
                    <span className="text-primary text-uppercase">{details.species}</span>
                    <h4>{details.name}</h4>
                    <div className="mt-3">
                        <div><b>Age:</b> {details.age} years old</div>
                        <div><b>Shelter Name:</b> {details.shelter}</div>
                        <div><b>Shelter Location:</b> {details.location}</div>
                    </div>
                </div>

            </div>
        </div>

    </>)
}