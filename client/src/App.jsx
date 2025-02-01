import { useEffect, useState } from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import "./App.css";
import Upload from "./components/Upload";
import BlogDetails from "./components/BlogDetails"; // Import BlogDetails component

function App() {
  const [blogData, setBlogData] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/blog")
      .then((response) => response.json())
      .then((data) => {
        if (Array.isArray(data)) {
          setBlogData(data); // Ensure it's an array before setting state
        } else {
          console.error("Invalid data format:", data);
        }
      })
      .catch((error) => console.error("Error fetching blogs:", error));
  }, []);

  return (
    <Router>
      <Routes>
        {/* Home Page - Blog Gallery */}
        <Route
          path="/"
          element={
            <main>
              <h1>Blogs Gallery</h1>
              <div className="container">
                {blogData.length > 0 ? (
                  blogData.map((blog) => (
                    <div key={blog.id} className="card">
                      <div className="card-body">
                        <h2>{blog.title}</h2>
                        <p>{blog.content.substring(0, 100)}...</p>
                        <Link to={`/blog/${blog.id}`} className="read-more">
                          Read More
                        </Link>
                      </div>
                    </div>
                  ))
                ) : (
                  <p>No blogs available.</p>
                )}
              </div>
              <Upload />
            </main>
          }
        />

        {/* Dynamic Blog Details Route */}
        <Route path="/blog/:id" element={<BlogDetails />} />
      </Routes>
    </Router>
  );
}

export default App;
