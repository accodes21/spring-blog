import { useEffect, useState } from "react";
import "./App.css";
import Upload from "./Upload";

function App() {
  const [blogData, setBlogData] = useState([]);
  useEffect(() => {
    fetch("http://localhost:8080/api/blog")
      .then((response) => response.json())
      .then((data) => setBlogData(data));
  }, []);

  console.log(blogData);

  return (
    <>
      <h1>Blogs Gallery</h1>
      <div className="container">
        {blogData?.map((blog) => (
          <div key={blog.id} className="card">
            <div className="card-body">
              <h2>{blog.title}</h2>
              <p>{blog.content}</p>
            </div>
          </div>
        ))}
      </div>
      <Upload />
    </>
  );
}

export default App;
