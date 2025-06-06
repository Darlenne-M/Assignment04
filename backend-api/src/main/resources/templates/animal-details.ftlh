<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO"
        crossorigin="anonymous"></script>
    <title>Animal Details</title>
</head>

<body style="background-color: lightgrey;">

    <!-- Begin Nav Bar -->
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
    </nav>
    <!-- End Nav Bar -->
<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <div class="card">
      <h5 class="card-header">${animal.name}</h5>
      <img src="/animalPictures/${(animal.animalPicturePath)!'avatar.png'}" class="card-img-top"
        style="height: 100px; width: 100px;" alt="animal picture">
      <div class="card-body">
      
        <h5 class="card-title">ID: ${animal.dogId?c}</h5>
        <p class="card-text">Name: ${animal.name}</p>
        <p class="card-text">Description: ${animal.description}</p>
        <p class="card-text">Breed: ${animal.breed}</p>
        <p class="card-text">Age: ${animal.age}</p>
        <span style="float:right"> <a href="/animals/delete/${animal.dogId?c}" class="btn btn-danger">Delete
          Animal</a></span>
        <a href="/animals/updateForm/${animal.dogId}" class="btn btn-primary" style="background-color: rgb(240, 192, 255); color: black; border: none; padding: 8px 16px; border-radius: 5px; cursor: pointer;">Edit
            Animal</a>
    
        <a href="/animals" class="btn btn-primary" style="background-color: rgb(240, 192, 255); color: black; border: none; padding: 8px 16px; border-radius: 5px; cursor: pointer;">Go back</a>
      </div>
    </div>

  </div>



</body>

</html>