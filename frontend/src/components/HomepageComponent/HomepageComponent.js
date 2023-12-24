import './styles.css'
import React, { useEffect } from 'react';
import secureLocalStorage  from  "react-secure-storage";
import { useLocation } from 'react-router-dom';

const HomepageComponent = () => {

    const location = useLocation()
    useEffect(() => {
        if (location.pathname === "/logout") {
            secureLocalStorage.removeItem("role");
            console.log("Logged out");
        }
    }, []);

    return(
        <>
        <div className="carousel slide mt-3" data-bs-ride="carousel" id="carousel-1" style={{height: "600px"}}>
            <div className="carousel-inner h-100">
                <div className="carousel-item active h-100">
                    <img className="w-100 d-block position-absolute h-100 fit-cover" src="/assets/img/homepage-picture-1.png" alt="Slide Image" style={{zIndex: -1}} />
                    <div className="container d-flex flex-column justify-content-center h-100 carouel-info">
                        <div className="row">
                            <div className="col-md-6 col-xl-4 offset-md-1">
                                <div style={{maxWidth: "350px"}}>
                                    <h1 className="text-uppercase fw-bold text-secondary stroke">Find your new best friend</h1>
                                    <p className="my-3">
                                        <span className="text-light">Explore a diverse array of lovable companions</span>
                                    </p>
                                    <a className="btn btn-primary btn-lg me-2" role="button" href="/register">Join</a>
                                    <a className="btn btn-outline-primary btn-lg text-light" role="button" href="/adopt">Pet Adoption</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div className="container py-4 py-xl-5">
        <div className="row mb-5">
            <div className="col-md-8 col-xl-6 text-center mx-auto">
                <h2 className="text-primary">Meet Our Adorable Pets</h2>
                <p className="w-lg-50">Curae hendrerit donec commodo hendrerit egestas tempus, turpis facilisis nostra nunc. Vestibulum dui eget ultrices.</p>
            </div>
        </div>
        <div className="row gy-4 row-cols-1 row-cols-md-2">
            <div className="col">
                <div className="d-flex flex-column flex-lg-row">
                    <div className="w-100"><img className="rounded img-fluid d-block w-100 fit-cover" style={{height: "200px"}} src="/assets/img/dog-looking-into-camera.jpeg" /></div>
                    <div className="py-4 py-lg-0 px-lg-4">
                        <h4>Find Your Furry Friend</h4>
                        <p>Explore our selection of lovable dogs waiting for a forever home. Each one comes with a unique story and a heart full of love.</p>
                    </div>
                </div>
            </div>
            <div className="col">
                <div className="d-flex flex-column flex-lg-row">
                    <div className="w-100"><img className="rounded img-fluid d-block w-100 fit-cover" style={{height: "200px"}} src="/assets/img/cute-cats.jpg.webp" /></div>
                    <div className="py-4 py-lg-0 px-lg-4">
                        <h4>Cuddle Up with a Cat</h4>
                        <p>Discover the joy of having a feline companion. Our cats are not just pets; they're family members ready to bring warmth to your home.</p>
                    </div>
                </div>
            </div>
            <div className="col">
                <div className="d-flex flex-column flex-lg-row">
                    <div className="w-100"><img className="rounded img-fluid d-block w-100 fit-cover" style={{height: "200px"}} src="/assets/img/tiny-pets.jpeg" /></div>
                    <div className="py-4 py-lg-0 px-lg-4">
                        <h4>Tiny Friends, Big Hearts</h4>
                        <p>From chirpy birds to cuddly bunnies, explore the world of small pets. They may be small in size, but their love knows no bounds.</p>
                    </div>
                </div>
            </div>
            <div className="col">
                <div className="d-flex flex-column flex-lg-row">
                    <div className="w-100"><img className="rounded img-fluid d-block w-100 fit-cover" style={{height: "200px"}} src="/assets/img/pet-with-family.avif" /></div>
                    <div className="py-4 py-lg-0 px-lg-4">
                        <h4>Happy Tails & Wagging Hearts</h4>
                        <p>Read inspiring stories of pets who found their forever homes. Join the ranks of happy adopters and be a part of our success stories.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section className="photo-gallery py-xl-3">
        <div className="container">
            <div className="row mb-5">
                <div className="col-md-8 col-xl-6 text-center mx-auto">
                    <h2 className="text-primary">Stories</h2>
                    <p>You have the opportunity to <a href="/adopt" className="text-primary fw-bold">save</a> them!</p>
                </div>
            </div>
            <div className="row gx-2 gy-2 row-cols-1 row-cols-md-2 row-cols-xl-3 photos" data-bss-baguettebox="">
                <div className="col item"><img className="img-fluid" src="/assets/img/sheep.png" /></div>
                <div className="col item"><img className="img-fluid" src="/assets/img/killed-sheep.png" /></div>
                <div className="col item"><img className="img-fluid" src="/assets/img/duck.png" /></div>
                <div className="col item"><img className="img-fluid" src="/assets/img/pigeon.png" /></div>
                <div className="col item"><img className="img-fluid" src="/assets/img/turkey.png" /></div>
                <div className="col item"><img className="img-fluid" src="/assets/img/cow.png" /></div>
            </div>
        </div>
    </section>
        </>
    );
};

export default HomepageComponent;