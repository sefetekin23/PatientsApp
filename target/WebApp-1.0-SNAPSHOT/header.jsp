<head>
  <style>
    /* Animation and Pseudo-classes */
    @keyframes pulseAnimation {
      0% { box-shadow: 0 0 0 0 rgba(13, 110, 253, 0.7); }
      70% { box-shadow: 0 0 0 10px rgba(13, 110, 253, 0); }
      100% { box-shadow: 0 0 0 0 rgba(13, 110, 253, 0); }
    }

    .centeredContainer {
      text-align: center; /* Centers the child inline elements */
      margin: 20px 0; /* Additional spacing */
    }

    .animatedLink {
      display: inline-block;
      background: #0d6efd; /* Bootstrap primary blue */
      color: #fff;
      padding: 10px 15px;
      border-radius: 5px;
      text-decoration: none;
      transition: all 0.3s ease;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      border: none;
      outline: none;
      cursor: pointer;
      font-size: 45px; /* Makes the button text larger */
    }

    .animatedLink:hover {
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      animation: pulseAnimation 1.5s infinite;
    }

    .animatedLink:focus {
      box-shadow: 0 0 0 3px rgba(13, 110, 253, 0.5);
    }
  </style>
</head>
<body>
<div class="centeredContainer">
  <a href="index.html" class="animatedLink">Patient Data App</a>
</div>
</body>
