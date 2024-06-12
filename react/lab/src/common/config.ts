export const backendServiceBaseUrl = import.meta.env.VITE_BACKEND_BASE_URL;

export const networks = {
  backendService: {
    url: backendServiceBaseUrl,
    endpoints: {
      post: {
        getAll: {
          url: '/posts',
          method: 'GET',
        },
        addPost: {
          url: '/posts',
          method: 'POST',
        },
        getSingle: {
          url: '/posts/{id}',
          method: 'GET',
        },
        deletePost: {
          url: '/posts/{id}',
          method: 'DELETE',
        },
        updatePost: {
          url: '/posts/{id}',
          method: 'PATCH',
        },
      },
    },
  },
};
