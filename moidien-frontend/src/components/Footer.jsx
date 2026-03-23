import "./footer.css";

export default function Footer(){
  return(
    <div className="footer">

      <div className="footer-left">
        <h2>FORTHEHOOD</h2>
        <p>Facebook</p>
        <p>Instagram</p>
      </div>

      <div className="footer-center">
        <h3>JOIN OUR EMAIL LIST</h3>
        <p>Be the first to know about our sales.</p>

        <input placeholder="Enter your email"/>
      </div>

      <div className="footer-right">
        <h3>MORE INFO</h3>
        <p>Contact</p>
        <p>Policy</p>
      </div>

    </div>
  )
}