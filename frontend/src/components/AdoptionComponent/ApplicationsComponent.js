import './styles.css'
import React, { useEffect, useState } from 'react';
import  secureLocalStorage  from  "react-secure-storage";


const ApplicationsComponent = () => {

    const [applications, setApplications] = useState([]);
    
    useEffect(() => {
        setApplications([
            {'id': 1, 'shelter': 'Shelter 1', 'pet': 'Fluffy', 'status': 'Pending'},
            {'id': 1, 'shelter': 'Shelter 1', 'pet': 'Fluffy', 'status': 'Pending'},
            {'id': 1, 'shelter': 'Shelter 1', 'pet': 'Fluffy', 'status': 'Pending'},
            {'id': 1, 'shelter': 'Shelter 1', 'pet': 'Fluffy', 'status': 'Pending'},
        ])
    })

    return(
        <>
            <div class="container py-2 py-xl-2">
                <h2>Applications</h2>
                <h5>Review your adoption applications status.</h5>
                <hr/>
                <table class="table table-striped table-hover text-center">
                    <thead>
                        <th>Application ID</th>
                        <th>Shelter Name</th>
                        <th>Pet Name</th>
                        <th>Application Status</th>
                    </thead>
                    <tbody>
                        {applications.map((application) => (
                            <tr>
                                <td>{application.id}</td>
                                <td>{application.shelter}</td>
                                <td>{application.pet}</td>
                                <td>{application.status}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </>
    );
};

export default ApplicationsComponent;