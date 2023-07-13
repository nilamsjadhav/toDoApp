import * as ReactDOM from "react-dom";
import React, {useEffect, useState} from "react";
import axios from "axios";

const App = () => {
    const [data, setData] = useState('');

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
};

ReactDOM.render(<App />, document.getElementById('root'));