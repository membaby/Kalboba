import React, { useEffect, useState } from 'react';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import './styles.css'


const DetailsComponent = () => {

    const SliderSettings = {
        dots: true,
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 1,
        speed: 500,
      };

    const [petInfo, setPetInfo] = useState({});
    useEffect(() => {
        setPetInfo(
        {
            'images': ['/animals/buddy.jpeg', '/animals/nibbles.jpeg', '/animals/tweety.jpeg', '/animals/whiskers.jpeg'],
            'name': 'Buddy',
            'category': 'Dog',
            'age': '2 years',
            'shelterName': 'Shelter 1',
            'shelterLocation': 'Shelter 1 Location',
            'id': 2,
        })
    }, []);

    return(
        <>
        <div class="container py-2 py-xl-2">
            <Slider {...SliderSettings}>
                {petInfo.images ? petInfo.images.map((d, index) => (
                    <>
                        <div className="img-container" height="200px" >
                            <img src={d} alt="pet" className="img-fluid" />
                        </div>
                    </>

                )) : (<>Loading..</>)}
            </Slider>
            
            <div className="row mt-3">
                <div className="col">
                    <div className="h1">{petInfo.name}</div>
                    <div className="h6 text-primary">{petInfo.category}</div>
                </div>
                <div className="col text-end">
                    <a href={`/adopt/`+petInfo.id}><button className="result-button result-button-primary mt-3 mb-3">Adopt Now</button></a>

                </div>
            </div>
            <hr/>
            <div className="row">
                <div className="col">
                    <div className="h5">INFORMATION</div>
                    <table className="table table-striped table-hover">
                        <tbody>
                            <tr><td>Name</td><td>{petInfo.name}</td></tr>
                            <tr><td>Age</td><td>{petInfo.age}</td></tr>
                            <tr><td>Shelter Name</td><td>{petInfo.shelterName}</td></tr>
                            <tr><td>Shelter Location</td><td>{petInfo.shelterLocation}</td></tr>
                        </tbody>
                    </table>
                </div>

                <div className="col">
                    <div className="h5">DOCUMENTS</div>
                    <table className="table table-striped table-hover">
                        <tbody>
                            <tr><td>Medical Records</td> <td>(PDF)</td> <td> <a href="/">Download</a>  </td></tr>
                            <tr><td>Medical Records</td> <td>(PDF)</td> <td> <a href="/">Download</a>  </td></tr>
                            <tr><td>Medical Records</td> <td>(PDF)</td> <td> <a href="/">Download</a>  </td></tr>
                            <tr><td>Medical Records</td> <td>(PDF)</td> <td> <a href="/">Download</a>  </td></tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div className="h5 mt-3">DESCRIPTION</div>
            ABC

            <hr/>
            

        </div>
        </>
    );
};

export default DetailsComponent;