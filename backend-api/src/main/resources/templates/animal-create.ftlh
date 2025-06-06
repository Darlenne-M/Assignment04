<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" 
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
    <title>Animal Create</title>
</head>
    
<body style="background-color: lightgrey;">

  <nav class="navbar navbar-expand-lg" style="background-color: rgb(240, 192, 255);">

    <div class="container-fluid">

      <a class="navbar-brand" href="#"><b>Sunny Paws Animal Shelter</b></a>

      <ul class="nav justify-content-end">
        <li class="nav-item">
          <a class="nav-link" href="/animals"><button>Home</button></a>
        </li>

         <li class="nav-item">
          <a class="nav-link" href="/animals/createForm"><button>Upload an Animal</button></a>
        </li>

        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#"><button>Contact Us</button> </a>
        </li>

      </ul>
    </div>
    </div>
  </nav>

  <div class="container" style="margin-top: 15px;" >
    <h1>${title}</h1>
    <form id="new-animal" action="/animals" method="post" enctype="multipart/form-data">
        <input type="text" id="name" name="name" placeholder="Name"/>
        <input type="description" id="description" name="description" placeholder="Description"/>
        <input type="text" id="breed" name="breed" placeholder="Breed"/>
        <input type="number" id="age" name="age" step="0.01" placeholder="AGE"/>
        <input type="file" id="picture" name="picture" required/><br><br>
        <button type="submit" class="btn btn-primary" style="background-color: rgb(240, 192, 255); color: black; border: none; padding: 8px 16px; border-radius: 5px; cursor: pointer;">Save</button>
       <a href="/animals" class="btn" style ="color: black; border: rgb(240, 192, 255);">Cancel</a>
    </form>

</div>

</body>
</html>