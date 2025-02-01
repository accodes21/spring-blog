import { useParams, Link } from "react-router-dom";
import { useEffect, useState } from "react";

function BlogDetails() {
  const { id } = useParams();
  const [blog, setBlog] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8080/api/blog/${id}`)
      .then((response) => response.json())
      .then((data) => {
        if (data.id) {
          setBlog(data);
        } else {
          console.error("Blog not found:", data);
        }
      })
      .catch((error) => console.error("Error fetching blog:", error));
  }, [id]);

  if (!blog) return <p>Loading...</p>;

  return (
    <main>
      <h1>{blog.title}</h1>
      <p>{blog.content}</p>
      <Link to="/">⬅ Back to Blogs</Link>
    </main>
  );
}

export default BlogDetails;
