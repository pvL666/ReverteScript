import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import './App.css';
import Main from './pages/main/Main';

const queryClient: QueryClient = new QueryClient();

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <Main />
    </QueryClientProvider>
  );
}

export default App;
