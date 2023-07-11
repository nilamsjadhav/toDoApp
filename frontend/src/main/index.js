import * as ReactDOM from "react-dom";
import React, {useEffect, useState} from "react";
import axios from "axios";

const App = () => {
    const [data, setData] = useState('');

    console.log('before axios', data)
    useEffect(() => {
        axios.get('/')
            .then((response) => {
                setData(response.data);
            })
            .catch((error) => {
                console.error('Error fetching data:', error);
            });
    }, []);

    return <div>{data}</div>;
    // console.log(data)
    // return <div>Hello world</div>;
};


ReactDOM.render(<App />, document.getElementById('root'));
// ReactDOM.render(<h1>Hello world</h1>, document.getElementById('root'));