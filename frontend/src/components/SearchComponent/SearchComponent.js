import React, { useState } from "react";
import Result from "./Result";

const SearchComponent = () => {

    const [showingResults, setShowingResults] = useState(false);
    const [results, setResults] = useState([]);
    const [totalResults, setTotalResults] = useState(0);
    const [currentPage, setCurrentPage] = useState(0);

    const search = (event) => {
        // prevent
        event.preventDefault();
        const keyword = document.getElementById('keyword').value;

        setResults([
            {'id': 1, 'name': 'Buddy', 'species': 'Dog', 'age': 3, 'sex': 'Male', 'shelter': 'Happy Paws Shelter', 'location': 'Cityville', 'image': 'buddy.jpeg'},
            {'id': 2, 'name': 'Whiskers', 'species': 'Cat', 'age': 2, 'sex': 'Female', 'shelter': 'Purrfect Haven', 'location': 'Kittytown', 'image': 'whiskers.jpeg'},
            {'id': 3, 'name': 'Nibbles', 'species': 'Rabbit', 'age': 1, 'sex': 'Male', 'shelter': 'Hoppy Homes', 'location': 'Bunnyville', 'image': 'nibbles.jpeg'},
            {'id': 4, 'name': 'Tweety', 'species': 'Bird', 'age': 1, 'sex': 'Male', 'shelter': 'Feathered Friends Sanctuary', 'location': 'Aviary Heights', 'image': 'tweety.jpeg'},
        ])
        setTotalResults(4);
        setShowingResults(true);
    }


    const setMessage = (message) => {
        document.getElementById('displayMessage').innerHTML = message;
    }
    
    return (
        <div>
            <div class="container py-2 py-xl-2">
                <h2>Search</h2>
                <h5>Browse pets from our network shelters and rescues.</h5>
                <hr/>
                <div className="text-center">
                    {!showingResults ? (
                        <img src="/assets/img/rover-windows-xp.gif" alt="ABC" width="100px" />
                    ) : (<></>)}
                    <div className="card">
                        <div className="card-body">
                            <div className="row">
                                <div className="col">
                                    <input type="text" className="form-control" placeholder="Search Terrier, Kitten, etc." id="keyword" />
                                </div>
                                <div className="col-auto">
                                    <a href="/" className="btn btn-primary px-5" onClick={search}>Search</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>


                <div className="mt-3">
                    <hr/>
                    {showingResults ? (
                        <>
                        <div>
                            {totalResults} Results Found - Page {currentPage+1} <span className="text-muted">(of {Math.ceil(totalResults/10)})</span>
                            <div className="results">
                            {results.map((result) => (
                                <Result details={result} />
                            ))}
                            </div>
                        </div>
                        <div className="text-center mt-3">
                            <button className="result-button result-button-primary">Previous Page</button>
                            <button className="result-button result-button-primary">Next Page</button>
                        </div>
                        </>
                    ) : (<></>)}
                </div>
            </div>
        </div>
    )
}

export default SearchComponent;