import "./navbar.css";

export default function Navbar() {
  return (
    <div className="navbar">
      <div className="logo">FORTHEHOOD</div>

      <div className="menu">
        <a>HOME</a>
        <a>SHOP</a>
        <a>ABOUT</a>
        <a>COLLECTION</a>
        <a>CAREERS</a>
      </div>

      <div className="right">
        <span>VND</span>
        <span>👤</span>
        <span>🛒</span>
      </div>
    </div>
  );
}