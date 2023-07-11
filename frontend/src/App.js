// import React, { useEffect, useState } from 'react';
// import axios from 'axios';
//
// const App = () => {
//     console.log("In app js");
//     const [data, setData] = useState('');
//
//     useEffect(() => {
//         axios.get('/')
//             .then((response) => {
//                 setData(response.data);
//             })
//             .catch((error) => {
//                 console.error('Error fetching data:', error);
//             });
//     }, []);
//
//     console.log(data)
//     return <div id="root">{data}</div>;
// };
//
// export default App;
